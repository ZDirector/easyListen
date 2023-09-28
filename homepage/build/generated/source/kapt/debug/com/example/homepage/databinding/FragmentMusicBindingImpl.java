package com.example.homepage.databinding;
import com.example.homepage.R;
import com.example.homepage.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMusicBindingImpl extends FragmentMusicBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.banner, 1);
        sViewsWithIds.put(R.id.cl_list, 2);
        sViewsWithIds.put(R.id.ll_recommended, 3);
        sViewsWithIds.put(R.id.rl_recommended, 4);
        sViewsWithIds.put(R.id.iv_recommended, 5);
        sViewsWithIds.put(R.id.tv_recommended, 6);
        sViewsWithIds.put(R.id.ll_personal_fm, 7);
        sViewsWithIds.put(R.id.rl_personal_fm, 8);
        sViewsWithIds.put(R.id.iv_personal_fm, 9);
        sViewsWithIds.put(R.id.tv_personal_fm, 10);
        sViewsWithIds.put(R.id.ll_list, 11);
        sViewsWithIds.put(R.id.rl_list, 12);
        sViewsWithIds.put(R.id.iv_list, 13);
        sViewsWithIds.put(R.id.tv_list, 14);
        sViewsWithIds.put(R.id.ll_playlist, 15);
        sViewsWithIds.put(R.id.rl_playlist, 16);
        sViewsWithIds.put(R.id.iv_playlist, 17);
        sViewsWithIds.put(R.id.tv_playlist, 18);
        sViewsWithIds.put(R.id.line1, 19);
        sViewsWithIds.put(R.id.tv_recommended_playlist, 20);
        sViewsWithIds.put(R.id.bt_more_recommended_playlist, 21);
        sViewsWithIds.put(R.id.lv_recommended_playlist, 22);
        sViewsWithIds.put(R.id.cl_list_top, 23);
        sViewsWithIds.put(R.id.tv_rank, 24);
        sViewsWithIds.put(R.id.bt_more_list, 25);
        sViewsWithIds.put(R.id.rv_list_rank, 26);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMusicBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }
    private FragmentMusicBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.youth.banner.Banner) bindings[1]
            , (android.widget.RelativeLayout) bindings[25]
            , (android.widget.RelativeLayout) bindings[21]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[23]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[5]
            , (android.view.View) bindings[19]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (com.example.common.widget.MusicSheetListView) bindings[22]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[8]
            , (android.widget.RelativeLayout) bindings[16]
            , (android.widget.RelativeLayout) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[20]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
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
        if (BR.music == variableId) {
            setMusic((com.example.homepage.music.viewmodel.MusicViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMusic(@Nullable com.example.homepage.music.viewmodel.MusicViewModel Music) {
        this.mMusic = Music;
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
        flag 0 (0x1L): music
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}