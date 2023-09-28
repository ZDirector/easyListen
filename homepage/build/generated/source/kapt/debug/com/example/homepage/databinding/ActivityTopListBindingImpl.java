package com.example.homepage.databinding;
import com.example.homepage.R;
import com.example.homepage.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTopListBindingImpl extends ActivityTopListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(25);
        sIncludes.setIncludes(1, 
            new String[] {"floating_play_control"},
            new int[] {2},
            new int[] {com.example.homepage.R.layout.floating_play_control});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.top_view, 3);
        sViewsWithIds.put(R.id.gl2, 4);
        sViewsWithIds.put(R.id.toolbar, 5);
        sViewsWithIds.put(R.id.bottom_view, 6);
        sViewsWithIds.put(R.id.ll_content, 7);
        sViewsWithIds.put(R.id.tab_layout, 8);
        sViewsWithIds.put(R.id.tab_official, 9);
        sViewsWithIds.put(R.id.tab_style, 10);
        sViewsWithIds.put(R.id.tab_global, 11);
        sViewsWithIds.put(R.id.tab_select, 12);
        sViewsWithIds.put(R.id.tab_features, 13);
        sViewsWithIds.put(R.id.scroll_view, 14);
        sViewsWithIds.put(R.id.tv_official, 15);
        sViewsWithIds.put(R.id.rv_official, 16);
        sViewsWithIds.put(R.id.tv_style, 17);
        sViewsWithIds.put(R.id.rv_style, 18);
        sViewsWithIds.put(R.id.tv_global, 19);
        sViewsWithIds.put(R.id.rv_global, 20);
        sViewsWithIds.put(R.id.tv_select, 21);
        sViewsWithIds.put(R.id.rv_select, 22);
        sViewsWithIds.put(R.id.tv_features, 23);
        sViewsWithIds.put(R.id.rv_features, 24);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @Nullable
    private final com.example.homepage.databinding.FloatingPlayControlBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityTopListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private ActivityTopListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.view.View) bindings[6]
            , (android.widget.FrameLayout) bindings[1]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (android.widget.LinearLayout) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (androidx.core.widget.NestedScrollView) bindings[14]
            , (com.google.android.material.tabs.TabItem) bindings[13]
            , (com.google.android.material.tabs.TabItem) bindings[11]
            , (com.google.android.material.tabs.TabLayout) bindings[8]
            , (com.google.android.material.tabs.TabItem) bindings[9]
            , (com.google.android.material.tabs.TabItem) bindings[12]
            , (com.google.android.material.tabs.TabItem) bindings[10]
            , (com.example.homepage.widget.TextBar) bindings[5]
            , (android.view.View) bindings[3]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[17]
            );
        this.flControlPlay.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.example.homepage.databinding.FloatingPlayControlBinding) bindings[2];
        setContainedBinding(this.mboundView1);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        mboundView1.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView1.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.example.homepage.toplist.viewmodel.TopListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.homepage.toplist.viewmodel.TopListViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView1.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(mboundView1);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}