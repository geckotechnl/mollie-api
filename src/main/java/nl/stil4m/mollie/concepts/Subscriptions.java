package nl.stil4m.mollie.concepts;

import com.fasterxml.jackson.core.type.TypeReference;
import nl.stil4m.mollie.RequestExecutor;
import nl.stil4m.mollie.ResponseOrError;
import nl.stil4m.mollie.domain.CreateSubscription;
import nl.stil4m.mollie.domain.Page;
import nl.stil4m.mollie.domain.Subscription;
import org.apache.http.client.methods.HttpDelete;

import java.io.IOException;

public class Subscriptions extends AbstractConcept<Subscription> implements ListAll<Subscription>, GetById<Subscription>, Create<Subscription, CreateSubscription> {

    protected static final TypeReference<Page<Subscription>> PAGE_TYPE = new TypeReference<Page<Subscription>>() {
    };
    protected static final TypeReference<Subscription> SINGLE_TYPE = new TypeReference<Subscription>() {
    };

    public Subscriptions(String apiKey, String endpoint, RequestExecutor requestExecutor, String customerId) {
        super(apiKey, requestExecutor, SINGLE_TYPE, PAGE_TYPE, endpoint, "customers", customerId, "subscriptions");
    }

    public ResponseOrError<Subscription> cancel(String id) throws IOException {
        HttpDelete httpDelete = new HttpDelete(url(id));
        return requestSingle(httpDelete);
    }

}
