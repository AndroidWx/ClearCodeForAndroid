package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.ColorActivityVu;
import com.joye.hk6domain.vo.ColorVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class ColorActivityPresenter extends ConstantsActivityPresenter<ColorActivityVu,ColorVo>{
    @Inject
    public ColorActivityPresenter(@Named("GetColorUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
