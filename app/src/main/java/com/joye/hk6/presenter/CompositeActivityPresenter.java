package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.CompositeActivityVu;
import com.joye.hk6domain.vo.CompositeVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class CompositeActivityPresenter extends ConstantsActivityPresenter<CompositeActivityVu,CompositeVo>{
    @Inject
    public CompositeActivityPresenter(@Named("GetCompositeCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);


    }
}
