package com.futurice.freesound.feature.search;

import com.futurice.freesound.inject.activity.BaseActivityModule;
import com.futurice.freesound.inject.activity.PerActivity;
import com.futurice.freesound.network.api.DefaultFreeSoundSearchService;
import com.futurice.freesound.network.api.FreeSoundApi;
import com.futurice.freesound.network.api.FreeSoundSearchService;

import dagger.Module;
import dagger.Provides;

@Module(includes = BaseActivityModule.class)
class SearchActivityModule {

    @Provides
    @PerActivity
    SearchViewModel provideSearchViewModel(SearchDataModel searchDataModel) {
        return new SearchViewModel(searchDataModel);
    }

    @Provides
    @PerActivity
    SearchDataModel provideSearchDataModel(FreeSoundSearchService freeSoundSearchService) {
        return new DefaultSearchDataModel(freeSoundSearchService);
    }

    @Provides
    @PerActivity
    FreeSoundSearchService provideFreeSoundsSearchService(FreeSoundApi freeSoundApi) {
        return new DefaultFreeSoundSearchService(freeSoundApi);
    }
}
