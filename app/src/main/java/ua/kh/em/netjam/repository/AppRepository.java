package ua.kh.em.netjam.repository;


import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netjam.model.Photo;
import ua.kh.em.netjam.model.Post;
import ua.kh.em.netjam.model.User;
import ua.kh.em.netjam.network.ApiClient;
import ua.kh.em.netjam.network.ApiService;

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
