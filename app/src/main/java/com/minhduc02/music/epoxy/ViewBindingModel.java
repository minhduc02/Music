package com.minhduc02.music.epoxy;

import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.viewbinding.ViewBinding;

import com.airbnb.epoxy.EpoxyModel;
import com.minhduc02.music.R;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.ConcurrentHashMap;

import kotlin.jvm.Synchronized;

public abstract class ViewBindingModel<T extends ViewBinding> extends EpoxyModel<View> {

    @LayoutRes
    private final int layoutRes;

    private final Method bindingMethod;

    public ViewBindingModel(int layoutRes) {
        this.layoutRes = layoutRes;
        this.bindingMethod = getBindMethodFrom(this.getClass());
    }

    public abstract void bind(T binding);

    @Override
    public void bind(View view) {
        T binding = (T) view.getTag(R.id.epoxy_viewbinding);
        if (binding == null) {
            try {
                binding = (T) bindingMethod.invoke(null, view);
            } catch (Exception e) {
                throw new RuntimeException("Failed to bind view", e);
            }
            view.setTag(R.id.epoxy_viewbinding, binding);
        }
        bind(binding);
    }

    @Override
    protected int getDefaultLayout() {
        return layoutRes;
    }

    // Static cache of a method pointer for each type of item used.
    private static final ConcurrentHashMap<Class<?>, Method> sBindingMethodByClass = new ConcurrentHashMap<>();

    @Synchronized
    private static Method getBindMethodFrom(Class<?> javaClass) {
        return sBindingMethodByClass.computeIfAbsent(javaClass, cls -> {
            try {
                ParameterizedType actualTypeOfThis = getSuperclassParameterizedType(cls);
                Class<?> viewBindingClass = (Class<?>) actualTypeOfThis.getActualTypeArguments()[0];
                return viewBindingClass.getDeclaredMethod("bind", View.class);
            } catch (Exception e) {
                throw new RuntimeException(
                        "The binder class " + javaClass.getCanonicalName() + " should have a method bind(View)", e);
            }
        });
    }

    private static ParameterizedType getSuperclassParameterizedType(Class<?> klass) {
        java.lang.reflect.Type genericSuperclass = klass.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            return (ParameterizedType) genericSuperclass;
        } else {
            return getSuperclassParameterizedType((Class<?>) genericSuperclass);
        }
    }
}
