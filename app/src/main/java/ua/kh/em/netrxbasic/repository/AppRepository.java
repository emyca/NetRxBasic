package ua.kh.em.netrxbasic.repository;


import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netrxbasic.model.Photo;
import ua.kh.em.netrxbasic.model.Post;
import ua.kh.em.netrxbasic.model.User;
import ua.kh.em.netrxbasic.network.ApiClient;
import ua.kh.em.netrxbasic.network.ApiService;

public class AppRepository {

    ApiService api;

    public Flowable<List<Post>> loadPosts() {
        api = ApiClient.getApiService();
        return api.loadPosts();
    }

    public Flowable<List<Photo>> loadPhotos() {
        api = ApiClient.getApiService();
        return api.loadPhotos();
    }

    public Flowable<List<User>> loadUsers() {
        api = ApiClient.getApiService();
        return api.loadUsers();
    }
}
