package ua.kh.em.netjam.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netjam.data.model.Post;
import ua.kh.em.netjam.data.repository.AppRepository;

public class PostViewModel extends ViewModel {

    AppRepository repository = new AppRepository();

    public Flowable<List<Post>> loadPosts() {
        return repository.loadPosts();
    }
}