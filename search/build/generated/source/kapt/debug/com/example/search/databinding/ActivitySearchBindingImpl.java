package com.example.search.databinding;
import com.example.search.R;
import com.example.search.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySearchBindingImpl extends ActivitySearchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.search_back, 1);
        sViewsWithIds.put(R.id.search_top_layout, 2);
        sViewsWithIds.put(R.id.search_text_input, 3);
        sViewsWithIds.put(R.id.search_editText_icon, 4);
        sViewsWithIds.put(R.id.search_editText_clear, 5);
        sViewsWithIds.put(R.id.nestedScrollView, 6);
        sViewsWithIds.put(R.id.search_main_layout, 7);
        sViewsWithIds.put(R.id.guideline1, 8);
        sViewsWithIds.put(R.id.guideline2, 9);
        sViewsWithIds.put(R.id.guideline3, 10);
        sViewsWithIds.put(R.id.search_history_layout, 11);
        sViewsWithIds.put(R.id.search_history_clear, 12);
        sViewsWithIds.put(R.id.search_history_list, 13);
        sViewsWithIds.put(R.id.search_recommend_text, 14);
        sViewsWithIds.put(R.id.search_recommend_list, 15);
        sViewsWithIds.put(R.id.search_hot_list_text, 16);
        sViewsWithIds.put(R.id.search_hot_list, 17);
        sViewsWithIds.put(R.id.search_suggest_list, 18);
        sViewsWithIds.put(R.id.search_loading_layout, 19);
        sViewsWithIds.put(R.id.search_loading_anim, 20);
        sViewsWithIds.put(R.id.textView, 21);
        sViewsWithIds.put(R.id.search_result_layout, 22);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private ActivitySearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.Guideline) bindings[8]
            , (androidx.constraintlayout.widget.Guideline) bindings[9]
            , (androidx.constraintlayout.widget.Guideline) bindings[10]
            , (androidx.core.widget.NestedScrollView) bindings[6]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (androidx.recyclerview.widget.RecyclerView) bindings[17]
            , (android.widget.TextView) bindings[16]
            , (com.wang.avi.AVLoadingIndicatorView) bindings[20]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[19]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[15]
            , (android.widget.TextView) bindings[14]
            , (com.example.common.baseui.assembly.BaseViewPage) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[18]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.TextView) bindings[21]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.searchViewModel == variableId) {
            setSearchViewModel((com.example.search.viewmodel.SearchViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSearchViewModel(@Nullable com.example.search.viewmodel.SearchViewModel SearchViewModel) {
        this.mSearchViewModel = SearchViewModel;
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): searchViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}