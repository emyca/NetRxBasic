package ua.kh.em.netrxbasic.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netrxbasic.model.Post;
import ua.kh.em.netrxbasic.repository.AppRepository;

public class PostViewModel extends ViewModel {

    AppRepository repository = new AppRepository();

    public Flowable<List<Post>> loadPosts() {
        return repository.loadPosts();
    }
}