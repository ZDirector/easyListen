// Generated by data binding compiler. Do not edit!
package com.example.search.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.common.baseui.assembly.BaseViewPage;
import com.example.search.R;
import com.example.search.viewmodel.SearchViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.wang.avi.AVLoadingIndicatorView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySearchBinding extends ViewDataBinding {
  @NonNull
  public final Guideline guideline1;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final ImageView searchBack;

  @NonNull
  public final ImageView searchEditTextClear;

  @NonNull
  public final ImageView searchEditTextIcon;

  @NonNull
  public final ImageView searchHistoryClear;

  @NonNull
  public final ConstraintLayout searchHistoryLayout;

  @NonNull
  public final RecyclerView searchHistoryList;

  @NonNull
  public final RecyclerView searchHotList;

  @NonNull
  public final TextView searchHotListText;

  @NonNull
  public final AVLoadingIndicatorView searchLoadingAnim;

  @NonNull
  public final ConstraintLayout searchLoadingLayout;

  @NonNull
  public final ConstraintLayout searchMainLayout;

  @NonNull
  public final RecyclerView searchRecommendList;

  @NonNull
  public final TextView searchRecommendText;

  @NonNull
  public final BaseViewPage searchResultLayout;

  @NonNull
  public final RecyclerView searchSuggestList;

  @NonNull
  public final TextInputEditText searchTextInput;

  @NonNull
  public final ConstraintLayout searchTopLayout;

  @Bindable
  protected SearchViewModel mSearchViewModel;

  protected ActivitySearchBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Guideline guideline1, Guideline guideline2, Guideline guideline3, ImageView searchBack,
      ImageView searchEditTextClear, ImageView searchEditTextIcon, ImageView searchHistoryClear,
      ConstraintLayout searchHistoryLayout, RecyclerView searchHistoryList,
      RecyclerView searchHotList, TextView searchHotListText,
      AVLoadingIndicatorView searchLoadingAnim, ConstraintLayout searchLoadingLayout,
      ConstraintLayout searchMainLayout, RecyclerView searchRecommendList,
      TextView searchRecommendText, BaseViewPage searchResultLayout, RecyclerView searchSuggestList,
      TextInputEditText searchTextInput, ConstraintLayout searchTopLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.guideline1 = guideline1;
    this.guideline2 = guideline2;
    this.guideline3 = guideline3;
    this.searchBack = searchBack;
    this.searchEditTextClear = searchEditTextClear;
    this.searchEditTextIcon = searchEditTextIcon;
    this.searchHistoryClear = searchHistoryClear;
    this.searchHistoryLayout = searchHistoryLayout;
    this.searchHistoryList = searchHistoryList;
    this.searchHotList = searchHotList;
    this.searchHotListText = searchHotListText;
    this.searchLoadingAnim = searchLoadingAnim;
    this.searchLoadingLayout = searchLoadingLayout;
    this.searchMainLayout = searchMainLayout;
    this.searchRecommendList = searchRecommendList;
    this.searchRecommendText = searchRecommendText;
    this.searchResultLayout = searchResultLayout;
    this.searchSuggestList = searchSuggestList;
    this.searchTextInput = searchTextInput;
    this.searchTopLayout = searchTopLayout;
  }

  public abstract void setSearchViewModel(@Nullable SearchViewModel searchViewModel);

  @Nullable
  public SearchViewModel getSearchViewModel() {
    return mSearchViewModel;
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchBinding>inflateInternal(inflater, R.layout.activity_search, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchBinding>inflateInternal(inflater, R.layout.activity_search, null, false, component);
  }

  public static ActivitySearchBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivitySearchBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySearchBinding)bind(component, view, R.layout.activity_search);
  }
}
