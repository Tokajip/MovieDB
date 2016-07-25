package com.tp.projects.blackswantest.persons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tp.projects.blackswantest.util.NetworkHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peti on 2016. 07. 22..
 */
public class PersonData implements Serializable {
    @SerializedName("profile_path")
    @Expose
    private String profilePath;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("known_for")
    @Expose
    private List<KnownFor> knownFor = new ArrayList<KnownFor>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("popularity")
    @Expose
    private Double popularity;

    /**
     * @return The profilePath
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     * @param profilePath The profile_path
     */
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    /**
     * @return The adult
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     * @param adult The adult
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The knownFor
     */
    public List<KnownFor> getKnownFor() {
        return knownFor;
    }

    /**
     * @param knownFor The known_for
     */
    public void setKnownFor(List<KnownFor> knownFor) {
        this.knownFor = knownFor;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     * @param popularity The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public class KnownFor implements Serializable {

        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("overview")
        @Expose
        private String overview;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("genre_ids")
        @Expose
        private List<Integer> genreIds = new ArrayList<Integer>();
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("media_type")
        @Expose
        private String mediaType;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("vote_count")
        @Expose
        private Integer voteCount;
        @SerializedName("video")
        @Expose
        private Boolean video;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;

        /**
         * @return The posterPath
         */
        public String getPosterPath() {
            return posterPath;
        }

        /**
         * @param posterPath The poster_path
         */
        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        /**
         * @return The adult
         */
        public Boolean getAdult() {
            return adult;
        }

        /**
         * @param adult The adult
         */
        public void setAdult(Boolean adult) {
            this.adult = adult;
        }

        /**
         * @return The overview
         */
        public String getOverview() {
            return overview;
        }

        /**
         * @param overview The overview
         */
        public void setOverview(String overview) {
            this.overview = overview;
        }

        /**
         * @return The releaseDate
         */
        public String getReleaseDate() {
            return releaseDate;
        }

        /**
         * @param releaseDate The release_date
         */
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        /**
         * @return The originalTitle
         */
        public String getOriginalTitle() {
            return originalTitle;
        }

        /**
         * @param originalTitle The original_title
         */
        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        /**
         * @return The genreIds
         */
        public List<Integer> getGenreIds() {
            return genreIds;
        }

        /**
         * @param genreIds The genre_ids
         */
        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        /**
         * @return The id
         */
        public Integer getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * @return The mediaType
         */
        public String getMediaType() {
            return mediaType;
        }

        /**
         * @param mediaType The media_type
         */
        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        /**
         * @return The originalLanguage
         */
        public String getOriginalLanguage() {
            return originalLanguage;
        }

        /**
         * @param originalLanguage The original_language
         */
        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The backdropPath
         */
        public String getBackdropPath() {
            return backdropPath;
        }

        /**
         * @param backdropPath The backdrop_path
         */
        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        /**
         * @return The popularity
         */
        public Double getPopularity() {
            return popularity;
        }

        /**
         * @param popularity The popularity
         */
        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        /**
         * @return The voteCount
         */
        public Integer getVoteCount() {
            return voteCount;
        }

        /**
         * @param voteCount The vote_count
         */
        public void setVoteCount(Integer voteCount) {
            this.voteCount = voteCount;
        }

        /**
         * @return The video
         */
        public Boolean getVideo() {
            return video;
        }

        /**
         * @param video The video
         */
        public void setVideo(Boolean video) {
            this.video = video;
        }

        /**
         * @return The voteAverage
         */
        public Double getVoteAverage() {
            return voteAverage;
        }

        /**
         * @param voteAverage The vote_average
         */
        public void setVoteAverage(Double voteAverage) {
            this.voteAverage = voteAverage;
        }

    }

    public void setImageURLs() {
        profilePath = NetworkHandler.createTileImageURL(profilePath);
    }

}

