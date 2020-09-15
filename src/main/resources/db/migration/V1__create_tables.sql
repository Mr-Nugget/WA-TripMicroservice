CREATE TABLE public.category
(
    category_id bigint NOT NULL,
    label character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT category_pkey PRIMARY KEY (category_id)
)

TABLESPACE pg_default;

ALTER TABLE public.category
    OWNER to wildadventure;

CREATE TABLE public.trip
(
    trip_id bigint NOT NULL,
    description text COLLATE pg_catalog."default",
    destination character varying(255) COLLATE pg_catalog."default",
    image_path character varying(255) COLLATE pg_catalog."default",
    label character varying(255) COLLATE pg_catalog."default",
    max_person integer,
    category_id bigint,
    CONSTRAINT trip_pkey PRIMARY KEY (trip_id),
    CONSTRAINT fkcb5nxtuyobn1auba9gpj7x0mx FOREIGN KEY (category_id)
        REFERENCES public.category (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.trip
    OWNER to wildadventure;

CREATE TABLE public.trip_instance
(
    dates_id bigint NOT NULL,
    begin_date timestamp without time zone,
    end_date timestamp without time zone,
    price real,
    trip_id bigint,
    CONSTRAINT trip_instance_pkey PRIMARY KEY (dates_id),
    CONSTRAINT fkp4777ltilngng6g7f890y7q84 FOREIGN KEY (trip_id)
        REFERENCES public.trip (trip_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.trip_instance
    OWNER to wildadventure;

CREATE TABLE public.comment
(
    comment_id bigint NOT NULL,
    content character varying(255) COLLATE pg_catalog."default",
    date timestamp without time zone,
    user_id bigint,
    username character varying(255) COLLATE pg_catalog."default",
    trip_id bigint,
    CONSTRAINT comment_pkey PRIMARY KEY (comment_id),
    CONSTRAINT fk9jail3uo4vf5uie24uyic5ud9 FOREIGN KEY (trip_id)
        REFERENCES public.trip (trip_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.comment
    OWNER to wildadventure;

