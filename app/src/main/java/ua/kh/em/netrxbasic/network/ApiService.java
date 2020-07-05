package ua.kh.em.netrxbasic.network;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import ua.kh.em.netrxbasic.model.Photo;
import ua.kh.em.netrxbasic.model.Post;
import ua.kh.em.netrxbasic.model.User;

public interface ApiService {

    @GET("posts")
    Flowable<List<Post>> loadPosts();

    @GET("photos")
    Flowable<List<Photo>> loadPhotos();

    @GET("users")
    Flowable<List<User>> loadUsers();
}
