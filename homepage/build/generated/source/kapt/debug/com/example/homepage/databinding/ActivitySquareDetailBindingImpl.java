package com.example.homepage.databinding;
import com.example.homepage.R;
import com.example.homepage.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySquareDetailBindingImpl extends ActivitySquareDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(28);
        sIncludes.setIncludes(1, 
            new String[] {"floating_play_control"},
            new int[] {10},
            new int[] {com.example.homepage.R.layout.floating_play_control});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.view_top, 11);
        sViewsWithIds.put(R.id.bottom_nav, 12);
        sViewsWithIds.put(R.id.coordinator, 13);
        sViewsWithIds.put(R.id.app_bar, 14);
        sViewsWithIds.put(R.id.toolbar_layout, 15);
        sViewsWithIds.put(R.id.cl_playlist, 16);
        sViewsWithIds.put(R.id.view_coo_bot, 17);
        sViewsWithIds.put(R.id.iv_comment, 18);
        sViewsWithIds.put(R.id.view_middle, 19);
        sViewsWithIds.put(R.id.iv_share, 20);
        sViewsWithIds.put(R.id.toolbar, 21);
        sViewsWithIds.put(R.id.scroll_view, 22);
        sViewsWithIds.put(R.id.ll_play_all, 23);
        sViewsWithIds.put(R.id.iv_play_all, 24);
        sViewsWithIds.put(R.id.tv_play_all, 25);
        sViewsWithIds.put(R.id.recyclerView, 26);
        sViewsWithIds.put(R.id.tv_title_bar, 27);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.FrameLayout mboundView1;
    @Nullable
    private final com.example.homepage.databinding.FloatingPlayControlBinding mboundView11;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySquareDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 28, sIncludes, sViewsWithIds));
    }
    private ActivitySquareDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.google.android.material.appbar.AppBarLayout) bindings[14]
            , (com.google.android.material.bottomnavigation.BottomNavigationView) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[16]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[13]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.LinearLayout) bindings[23]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[22]
            , (androidx.appcompat.widget.Toolbar) bindings[21]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[15]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[3]
            , (android.view.View) bindings[17]
            , (android.view.View) bindings[19]
            , (android.view.View) bindings[11]
            );
        this.ibPlaylist.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.FrameLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (com.example.homepage.databinding.FloatingPlayControlBinding) bindings[10];
        setContainedBinding(this.mboundView11);
        this.tvCreator.setTag(null);
        this.tvDescribe.setTag(null);
        this.tvNumberComment.setTag(null);
        this.tvNumberShare.setTag(null);
        this.tvSongSize.setTag(null);
        this.tvTitleBarPlay.setTag(null);
        this.tvTitlePlaylist.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        mboundView11.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView11.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.example.homepage.playSquare.viewmodel.PlayListDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.homepage.playSquare.viewmodel.PlayListDetailViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelNameLiveData((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelListLiveData((androidx.lifecycle.LiveData<com.example.common.bean.home.Playlist>) object, fieldId);
            case 2 :
                return onChangeViewModelUrlLiveData((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelNameLiveData(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelNameLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelListLiveData(androidx.lifecycle.LiveData<com.example.common.bean.home.Playlist> ViewModelListLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelUrlLiveData(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelUrlLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
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
        java.lang.String stringValueOfViewModelListLiveDataShareCount = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelNameLiveData = null;
        int viewModelListLiveDataShareCount = 0;
        int viewModelListLiveDataCommentCount = 0;
        java.lang.String viewModelListLiveDataName = null;
        java.lang.String viewModelListLiveDataCreatorNickname = null;
        java.lang.String stringValueOfViewModelListLiveDataCreatorNickname = null;
        androidx.lifecycle.LiveData<com.example.common.bean.home.Playlist> viewModelListLiveData = null;
        com.example.common.bean.home.Creator viewModelListLiveDataCreator = null;
        long viewModelListLiveDataPlayCount = 0;
        java.lang.String viewModelNameLiveDataGetValue = null;
        com.example.common.bean.home.Playlist viewModelListLiveDataGetValue = null;
        java.lang.String stringValueOfViewModelListLiveDataPlayCount = null;
        java.lang.String viewModelUrlLiveDataGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelUrlLiveData = null;
        java.lang.String stringValueOfViewModelListLiveDataCommentCount = null;
        com.example.homepage.playSquare.viewmodel.PlayListDetailViewModel viewModel = mViewModel;
        java.lang.String viewModelListLiveDataDescription = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.nameLiveData
                        viewModelNameLiveData = viewModel.getNameLiveData();
                    }
                    updateLiveDataRegistration(0, viewModelNameLiveData);


                    if (viewModelNameLiveData != null) {
                        // read viewModel.nameLiveData.getValue()
                        viewModelNameLiveDataGetValue = viewModelNameLiveData.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.listLiveData
                        viewModelListLiveData = viewModel.getListLiveData();
                    }
                    updateLiveDataRegistration(1, viewModelListLiveData);


                    if (viewModelListLiveData != null) {
                        // read viewModel.listLiveData.getValue()
                        viewModelListLiveDataGetValue = viewModelListLiveData.getValue();
                    }


                    if (viewModelListLiveDataGetValue != null) {
                        // read viewModel.listLiveData.getValue().shareCount
                        viewModelListLiveDataShareCount = viewModelListLiveDataGetValue.getShareCount();
                        // read viewModel.listLiveData.getValue().commentCount
                        viewModelListLiveDataCommentCount = viewModelListLiveDataGetValue.getCommentCount();
                        // read viewModel.listLiveData.getValue().name
                        viewModelListLiveDataName = viewModelListLiveDataGetValue.getName();
                        // read viewModel.listLiveData.getValue().creator
                        viewModelListLiveDataCreator = viewModelListLiveDataGetValue.getCreator();
                        // read viewModel.listLiveData.getValue().playCount
                        viewModelListLiveDataPlayCount = viewModelListLiveDataGetValue.getPlayCount();
                        // read viewModel.listLiveData.getValue().description
                        viewModelListLiveDataDescription = viewModelListLiveDataGetValue.getDescription();
                    }


                    // read String.valueOf(viewModel.listLiveData.getValue().shareCount)
                    stringValueOfViewModelListLiveDataShareCount = java.lang.String.valueOf(viewModelListLiveDataShareCount);
                    // read String.valueOf(viewModel.listLiveData.getValue().commentCount)
                    stringValueOfViewModelListLiveDataCommentCount = java.lang.String.valueOf(viewModelListLiveDataCommentCount);
                    // read String.valueOf(viewModel.listLiveData.getValue().playCount)
                    stringValueOfViewModelListLiveDataPlayCount = java.lang.String.valueOf(viewModelListLiveDataPlayCount);
                    if (viewModelListLiveDataCreator != null) {
                        // read viewModel.listLiveData.getValue().creator.nickname
                        viewModelListLiveDataCreatorNickname = viewModelListLiveDataCreator.getNickname();
                    }


                    // read String.valueOf(viewModel.listLiveData.getValue().creator.nickname)
                    stringValueOfViewModelListLiveDataCreatorNickname = java.lang.String.valueOf(viewModelListLiveDataCreatorNickname);
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.urlLiveData
                        viewModelUrlLiveData = viewModel.getUrlLiveData();
                    }
                    updateLiveDataRegistration(2, viewModelUrlLiveData);


                    if (viewModelUrlLiveData != null) {
                        // read viewModel.urlLiveData.getValue()
                        viewModelUrlLiveDataGetValue = viewModelUrlLiveData.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            com.example.common.utils.DataBindingExtensionKt.loadImage(this.ibPlaylist, viewModelUrlLiveDataGetValue);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCreator, stringValueOfViewModelListLiveDataCreatorNickname);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDescribe, viewModelListLiveDataDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvNumberComment, stringValueOfViewModelListLiveDataCommentCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvNumberShare, stringValueOfViewModelListLiveDataShareCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSongSize, stringValueOfViewModelListLiveDataPlayCount);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitleBarPlay, viewModelListLiveDataName);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitlePlaylist, viewModelNameLiveDataGetValue);
        }
        executeBindingsOn(mboundView11);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.nameLiveData
        flag 1 (0x2L): viewModel.listLiveData
        flag 2 (0x3L): viewModel.urlLiveData
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}