package ua.kh.em.netjam.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netjam.model.Post;
import ua.kh.em.netjam.repository.AppRepository;

public class PostViewModel extends ViewModel {

    AppRepository repository = new AppRepository();

    public Flowable<List<Post>> loadPosts() {
        return repository.loadPosts();
    }
}