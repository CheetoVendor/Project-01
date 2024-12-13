drop table if exists account;

drop table if exists post;

drop table if exists comments;

drop table if exists likes;

drop table if exists follow;

create table account (
    account_id int primary key auto_increment,
    username varchar(255) not null unique,
    password varchar(255),
    bio_text varchar(255),
    profile_picture_url varchar(255),
    time_created_epoch bigint
);

create table post (
    post_id int primary key auto_increment,
    posted_by int,
    post_text varchar(255),
    image_url varchar(255),
    video_url varchar(255),
    foreign key (posted_by) references account (account_id)
);

create table comments (
    comment_id int primary key auto_increment,
    post_id int,
    foreign key (post_id) references post (post_id),
    posted_by int,
    foreign key (posted_by) references account (account_id),
    comment_text varchar(255),
    time_posted_epoch bigint,
    time_updated_epoch bigint
);

create table likes (
    like_id int primary key auto_increment,
    post_id int,
    foreign key (post_id) references post (post_id),
    account_id int,
    foreign key (account_id) references account (account_id),
    type int,
    time_liked_epoch bigint
);

create table follow (
    follower_id int,
    followed_id int,
    time_created_epoch bigint,
    foreign key (follower_id) references account (account_id),
    foreign key (followed_id) references account (account_id)
);

insert into account (username, password) VALUES ('test', 'test');