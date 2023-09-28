package com.example.homepage;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.homepage.databinding.ActivityHomeBindingImpl;
import com.example.homepage.databinding.ActivitySongSquareBindingImpl;
import com.example.homepage.databinding.ActivitySquareDetailBindingImpl;
import com.example.homepage.databinding.ActivityTopListBindingImpl;
import com.example.homepage.databinding.ActivityWebBindingImpl;
import com.example.homepage.databinding.FloatingPlayControlBindingImpl;
import com.example.homepage.databinding.FragmentMusicBindingImpl;
import com.example.homepage.databinding.FragmentPlaySquareDetailBindingImpl;
import com.example.homepage.databinding.FragmentSquareRecommendBindingImpl;
import com.example.homepage.databinding.FragmentTermServiceDialogBindingImpl;
import com.example.homepage.databinding.ItemListRankingBindingImpl;
import com.example.homepage.databinding.ItemSquareListBindingImpl;
import com.example.homepage.databinding.ItemTopOfficialBindingImpl;
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
  private static final int LAYOUT_ACTIVITYHOME = 1;

  private static final int LAYOUT_ACTIVITYSONGSQUARE = 2;

  private static final int LAYOUT_ACTIVITYSQUAREDETAIL = 3;

  private static final int LAYOUT_ACTIVITYTOPLIST = 4;

  private static final int LAYOUT_ACTIVITYWEB = 5;

  private static final int LAYOUT_FLOATINGPLAYCONTROL = 6;

  private static final int LAYOUT_FRAGMENTMUSIC = 7;

  private static final int LAYOUT_FRAGMENTPLAYSQUAREDETAIL = 8;

  private static final int LAYOUT_FRAGMENTSQUARERECOMMEND = 9;

  private static final int LAYOUT_FRAGMENTTERMSERVICEDIALOG = 10;

  private static final int LAYOUT_ITEMLISTRANKING = 11;

  private static final int LAYOUT_ITEMSQUARELIST = 12;

  private static final int LAYOUT_ITEMTOPOFFICIAL = 13;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(13);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.activity_song_square, LAYOUT_ACTIVITYSONGSQUARE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.activity_square_detail, LAYOUT_ACTIVITYSQUAREDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.activity_top_list, LAYOUT_ACTIVITYTOPLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.activity_web, LAYOUT_ACTIVITYWEB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.floating_play_control, LAYOUT_FLOATINGPLAYCONTROL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.fragment_music, LAYOUT_FRAGMENTMUSIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.fragment_play_square_detail, LAYOUT_FRAGMENTPLAYSQUAREDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.fragment_square_recommend, LAYOUT_FRAGMENTSQUARERECOMMEND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.fragment_term_service_dialog, LAYOUT_FRAGMENTTERMSERVICEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.item_list_ranking, LAYOUT_ITEMLISTRANKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.item_square_list, LAYOUT_ITEMSQUARELIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.homepage.R.layout.item_top_official, LAYOUT_ITEMTOPOFFICIAL);
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
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSONGSQUARE: {
          if ("layout/activity_song_square_0".equals(tag)) {
            return new ActivitySongSquareBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_song_square is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSQUAREDETAIL: {
          if ("layout/activity_square_detail_0".equals(tag)) {
            return new ActivitySquareDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_square_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTOPLIST: {
          if ("layout/activity_top_list_0".equals(tag)) {
            return new ActivityTopListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_top_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWEB: {
          if ("layout/activity_web_0".equals(tag)) {
            return new ActivityWebBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_web is invalid. Received: " + tag);
        }
        case  LAYOUT_FLOATINGPLAYCONTROL: {
          if ("layout/floating_play_control_0".equals(tag)) {
            return new FloatingPlayControlBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for floating_play_control is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMUSIC: {
          if ("layout/fragment_music_0".equals(tag)) {
            return new FragmentMusicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_music is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPLAYSQUAREDETAIL: {
          if ("layout/fragment_play_square_detail_0".equals(tag)) {
            return new FragmentPlaySquareDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_play_square_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSQUARERECOMMEND: {
          if ("layout/fragment_square_recommend_0".equals(tag)) {
            return new FragmentSquareRecommendBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_square_recommend is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTERMSERVICEDIALOG: {
          if ("layout/fragment_term_service_dialog_0".equals(tag)) {
            return new FragmentTermServiceDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_term_service_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLISTRANKING: {
          if ("layout/item_list_ranking_0".equals(tag)) {
            return new ItemListRankingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_list_ranking is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSQUARELIST: {
          if ("layout/item_square_list_0".equals(tag)) {
            return new ItemSquareListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_square_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMTOPOFFICIAL: {
          if ("layout/item_top_official_0".equals(tag)) {
            return new ItemTopOfficialBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_top_official is invalid. Received: " + tag);
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
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(3);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.example.common.DataBinderMapperImpl());
    result.add(new com.example.search.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(11);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "music");
      sKeys.put(2, "musicCommentViewModel");
      sKeys.put(3, "musicResultViewModel");
      sKeys.put(4, "musicSheetViewModel");
      sKeys.put(5, "musicVideoViewModel");
      sKeys.put(6, "searchUserViewModel");
      sKeys.put(7, "searchViewModel");
      sKeys.put(8, "videoFragmentViewModel");
      sKeys.put(9, "videoViewModel");
      sKeys.put(10, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(13);

    static {
      sKeys.put("layout/activity_home_0", com.example.homepage.R.layout.activity_home);
      sKeys.put("layout/activity_song_square_0", com.example.homepage.R.layout.activity_song_square);
      sKeys.put("layout/activity_square_detail_0", com.example.homepage.R.layout.activity_square_detail);
      sKeys.put("layout/activity_top_list_0", com.example.homepage.R.layout.activity_top_list);
      sKeys.put("layout/activity_web_0", com.example.homepage.R.layout.activity_web);
      sKeys.put("layout/floating_play_control_0", com.example.homepage.R.layout.floating_play_control);
      sKeys.put("layout/fragment_music_0", com.example.homepage.R.layout.fragment_music);
      sKeys.put("layout/fragment_play_square_detail_0", com.example.homepage.R.layout.fragment_play_square_detail);
      sKeys.put("layout/fragment_square_recommend_0", com.example.homepage.R.layout.fragment_square_recommend);
      sKeys.put("layout/fragment_term_service_dialog_0", com.example.homepage.R.layout.fragment_term_service_dialog);
      sKeys.put("layout/item_list_ranking_0", com.example.homepage.R.layout.item_list_ranking);
      sKeys.put("layout/item_square_list_0", com.example.homepage.R.layout.item_square_list);
      sKeys.put("layout/item_top_official_0", com.example.homepage.R.layout.item_top_official);
    }
  }
}
