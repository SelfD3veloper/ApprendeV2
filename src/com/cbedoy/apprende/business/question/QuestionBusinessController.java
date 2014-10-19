package com.cbedoy.apprende.business.question;

import com.cbedoy.apprende.business.BusinessController;
import com.cbedoy.apprende.business.question.interfaces.IQuestionInformationDelegate;
import com.cbedoy.apprende.business.question.interfaces.IQuestionInformationHandler;
import com.cbedoy.apprende.business.question.interfaces.IQuestionRepresentationDelegate;
import com.cbedoy.apprende.business.question.interfaces.IQuestionRepresentationHandler;
import com.cbedoy.apprende.business.question.interfaces.IQuestionTransactionDelegate;
import com.cbedoy.apprende.business.question.interfaces.IQuestionTransactionHandler;

import java.util.HashMap;

/**
 * Created by Carlos on 15/10/2014.
 */
public class QuestionBusinessController extends BusinessController implements IQuestionTransactionDelegate, IQuestionRepresentationDelegate, IQuestionInformationDelegate{

    private IQuestionTransactionHandler questionTransactionHandler;
    private IQuestionInformationHandler questionInformationHandler;
    private IQuestionRepresentationHandler questionRepresentationHandler;

    public void setQuestionInformationHandler(IQuestionInformationHandler questionInformationHandler) {
        this.questionInformationHandler = questionInformationHandler;
    }

    public void setQuestionRepresentationHandler(IQuestionRepresentationHandler questionRepresentationHandler) {
        this.questionRepresentationHandler = questionRepresentationHandler;
    }

    public void setQuestionTransactionHandler(IQuestionTransactionHandler questionTransactionHandler) {
        this.questionTransactionHandler = questionTransactionHandler;
    }

    @Override
    public void questionaryResponse(HashMap<String, Object> response) {

    }

    @Override
    public void userStartApprende() {

    }

    @Override
    public void showNextQuestion() {

    }

    @Override
    public void showPassQuestion() {

    }

    @Override
    public void startQuestionaryApprende() {

    }
}

