package streams;

import factories.ResourceChangeResolver;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import providers.ResourceProvider;
import resource.changes.ChangeType;
import resource.changes.ResourceChange;
import resource.changes.ResourceChangeImpl;

import java.util.concurrent.TimeUnit;

public class ResourceStream extends Observable<ResourceChange> {
    private  final ResourceProvider resourceProvider;
    private final Observable<ResourceChange> internalObservable;
    private final ResourceChangeResolver resourceChangeResolver;

    public ResourceStream(ResourceProvider resourceProvider) {
        resourceChangeResolver = new ResourceChangeResolver();
        this.resourceProvider = resourceProvider;
        internalObservable = Observable.interval(resourceProvider.interval().getSeconds(), TimeUnit.SECONDS)
                .flatMap(ignored -> Observable.fromIterable(resourceChangeResolver.calculateDeltas(resourceProvider.resources())));

    }

    @Override
    protected void subscribeActual(@NonNull Observer<? super ResourceChange> observer) {
        internalObservable.subscribe(observer);
    }


}
