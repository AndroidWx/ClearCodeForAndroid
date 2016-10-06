package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.CompositeSizeActivityVu;
import com.joye.hk6domain.vo.CompositeSizeVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class CompositeSizeActivityPresenter extends ConstantsActivityPresenter<CompositeSizeActivityVu,CompositeSizeVo>{
    @Inject
    public CompositeSizeActivityPresenter(@Named("GetCompositeSizeUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);


    }
}
