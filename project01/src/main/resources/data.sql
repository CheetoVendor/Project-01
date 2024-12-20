create table if not exists account (
    account_id int primary key auto_increment,
    username varchar(255) not null unique,
    password varchar(255),
    bio_text varchar(255),
    profile_picture_url varchar(255),
    time_created_epoch bigint
);

create table if not exists post (
    post_id int primary key auto_increment,
    posted_by int,
    post_text varchar(255),
    image_url varchar(255),
    video_url varchar(255),
    foreign key (posted_by) references account (account_id)
);

create table if not exists comments (
    comment_id int primary key auto_increment,
    post_id int,
    foreign key (post_id) references post (post_id),
    posted_by int,
    foreign key (posted_by) references account (account_id),
    comment_text varchar(255),
    time_posted_epoch bigint,
    time_updated_epoch bigint
);

create table if not exists likes (
    like_id int primary key auto_increment,
    post_id int,
    foreign key (post_id) references post (post_id),
    account_id int,
    foreign key (account_id) references account (account_id),
    type int,
    time_liked_epoch bigint
);

create table if not exists follow (
    follow_id int primary key auto_increment,
    follower_id int,
    followed_id int,
    time_created_epoch bigint,
    foreign key (follower_id) references account (account_id),
    foreign key (followed_id) references account (account_id)
);

-- STATUS KEY
-- 0 - Pending
-- 1 - Accepted
-- -1 - Declined

create table if not exists friend (
    friend_id int primary key auto_increment,
    friend_status int,
    friender_id int,
    friended_id int,
    time_created_epoch bigint,
    foreign key (friender_id) references account (account_id),
    foreign key (friended_id) references account (account_id)
);

insert into
    account (
        username,
        password,
        profile_picture_url
    )
VALUES (
        'test',
        '$2a$12$W2YLeUSYw7c6SlciV7k4H.xcX0WvDdh/B1G5bAnPXNn19nY40CKPO',
        'https://imgv3.fotor.com/images/blog-cover-image/10-profile-picture-ideas-to-make-you-stand-out.jpg'
    );

insert INTO
    account (
        username,
        password,
        profile_picture_url
    )
VALUES (
        'Peter Griffin',
        '$2a$12$W2YLeUSYw7c6SlciV7k4H.xcX0WvDdh/B1G5bAnPXNn19nY40CKPO',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDmsLwfBRlH9chKLfDIQdljtUuAHTbI_7XUw&s'
    );

insert INTO
    friend (
        friend_status,
        friender_id,
        friended_id
    )
values (1, 2, 1);

INSERT INTO
    post (
        posted_by,
        post_text,
        image_url,
        video_url
    )
VALUES (
        1,
        'Look at this adorable kitten!',
        'https://media.gettyimages.com/id/138468381/photo/kitten-on-lap.jpg?s=2048x2048&w=gi&k=20&c=dVn6n2Bg01K9mbVR7V4PDmSYY47n_nQFhoii_FW73JE=',
        'https://example.com/cat_video1.mp4'
    ),
    (
        1,
        'My cat loves to sleep on the couch all day.',
        'https://media.gettyimages.com/id/1480061433/photo/cute-siamese-kitten-on-a-sofa.jpg?s=2048x2048&w=gi&k=20&c=2ObQfDsQ4WHIx8bQCu5aIkPe9c4Gl_nvrEQ8UWvvCM8=',
        'https://example.com/cat_video2.mp4'
    ),
    (
        1,
        'This cat just caught its first mouse!',
        'https://media.gettyimages.com/id/157512060/photo/kitten-plays-with-toy-mouse.jpg?s=2048x2048&w=gi&k=20&c=FnqOuEba3LcI0hV0joTO1_1DQxnt2iA4DrPSgTqVYMo=',
        'https://example.com/cat_video3.mp4'
    ),
    (
        1,
        'Meet my new cat, Whiskers!',
        'https://media.gettyimages.com/id/158906394/photo/kitten-playing-with-mouse-toy-on-floor.jpg?s=2048x2048&w=gi&k=20&c=VNIPg8Lsj8fo7jcqDvzmTACtCHks3LRbZgF0BEfxOMw=',
        'https://example.com/cat_video4.mp4'
    ),
    (
        1,
        'Isn’t this the cutest cat video ever?',
        'https://example.com/cat5.jpg',
        'https://example.com/cat_video5.mp4'
    );