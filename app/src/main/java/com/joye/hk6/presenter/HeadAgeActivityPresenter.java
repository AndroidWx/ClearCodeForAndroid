package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.HeadAgeActivityVu;
import com.joye.hk6domain.vo.HeadAgeVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class HeadAgeActivityPresenter extends ConstantsActivityPresenter<HeadAgeActivityVu,HeadAgeVo>{
    @Inject
    public HeadAgeActivityPresenter(@Named("GetHeadAgeUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);

    }
}
