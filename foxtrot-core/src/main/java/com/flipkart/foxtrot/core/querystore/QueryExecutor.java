package com.flipkart.foxtrot.core.querystore;

import com.flipkart.foxtrot.common.query.CachableResponseGenerator;
import com.flipkart.foxtrot.core.common.Action;
import com.flipkart.foxtrot.core.common.ActionResponse;
import com.flipkart.foxtrot.core.common.AsyncDataToken;

import java.util.concurrent.ExecutorService;

/**
 * User: Santanu Sinha (santanu.sinha@flipkart.com)
 * Date: 24/03/14
 * Time: 12:51 PM
 */
public class QueryExecutor {
    private ExecutorService executorService;

    public QueryExecutor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public <P extends CachableResponseGenerator,T extends ActionResponse> T execute(
                                            Action<P,T> action) throws QueryStoreException {
        return action.execute();
    }

    public AsyncDataToken executeAsync(Action action) {
        return action.execute(executorService);
    }
}