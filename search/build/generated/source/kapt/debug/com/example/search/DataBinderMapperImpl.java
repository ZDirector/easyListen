package com.example.search;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.search.databinding.ActivitySearchBindingImpl;
import com.example.search.databinding.FragmentMusicResultBindingImpl;
import com.example.search.databinding.FragmentMusicSheetBindingImpl;
import com.example.search.databinding.FragmentMusicViedoBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYSEARCH = 1;

  private static final int LAYOUT_FRAGMENTMUSICRESULT = 2;

  private static final int LAYOUT_FRAGMENTMUSICSHEET = 3;

  private static final int LAYOUT_FRAGMENTMUSICVIEDO = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.search.R.layout.activity_search, LAYOUT_ACTIVITYSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.search.R.layout.fragment_music_result, LAYOUT_FRAGMENTMUSICRESULT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.search.R.layout.fragment_music_sheet, LAYOUT_FRAGMENTMUSICSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.search.R.layout.fragment_music_viedo, LAYOUT_FRAGMENTMUSICVIEDO);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYSEARCH: {
          if ("layout/activity_search_0".equals(tag)) {
            return new ActivitySearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMUSICRESULT: {
          if ("layout/fragment_music_result_0".equals(tag)) {
            return new FragmentMusicResultBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_music_result is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMUSICSHEET: {
          if ("layout/fragment_music_sheet_0".equals(tag)) {
            return new FragmentMusicSheetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_music_sheet is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMUSICVIEDO: {
          if ("layout/fragment_music_viedo_0".equals(tag)) {
            return new FragmentMusicViedoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_music_viedo is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.example.common.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "musicResultViewModel");
      sKeys.put(2, "musicSheetViewModel");
      sKeys.put(3, "musicVideoViewModel");
      sKeys.put(4, "searchViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_search_0", com.example.search.R.layout.activity_search);
      sKeys.put("layout/fragment_music_result_0", com.example.search.R.layout.fragment_music_result);
      sKeys.put("layout/fragment_music_sheet_0", com.example.search.R.layout.fragment_music_sheet);
      sKeys.put("layout/fragment_music_viedo_0", com.example.search.R.layout.fragment_music_viedo);
    }
  }
}
