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
    follower_id int,
    followed_id int,
    time_created_epoch bigint,
    foreign key (follower_id) references account (account_id),
    foreign key (followed_id) references account (account_id)
);

insert into
    account (
        username,
        password,
        profile_picture_url
    )
VALUES (
        'test',
        'test',
        'https://imgv3.fotor.com/images/blog-cover-image/10-profile-picture-ideas-to-make-you-stand-out.jpg'
    );

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
        'https://example.com/cat1.jpg',
        'https://example.com/cat_video1.mp4'
    ),
    (
        1,
        'My cat loves to sleep on the couch all day.',
        'https://example.com/cat2.jpg',
        'https://example.com/cat_video2.mp4'
    ),
    (
        1,
        'This cat just caught its first mouse!',
        'https://example.com/cat3.jpg',
        'https://example.com/cat_video3.mp4'
    ),
    (
        1,
        'Meet my new cat, Whiskers!',
        'https://example.com/cat4.jpg',
        'https://example.com/cat_video4.mp4'
    ),
    (
        1,
        'Isn’t this the cutest cat video ever?',
        'https://example.com/cat5.jpg',
        'https://example.com/cat_video5.mp4'
    );