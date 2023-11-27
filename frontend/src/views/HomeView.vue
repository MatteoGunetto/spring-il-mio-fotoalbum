<script setup>
import { ref, onMounted } from 'vue';
import axios from "axios";

const base_url = "http://localhost:8080/api/v1"
const photos_endpoint = "/photos"

const data = ref({
    photos: [],
    message: "",
    email: "",
    filter: "",
})

onMounted(() => {
    axios.get(base_url + photos_endpoint)
        .then(response => {
            data.value.photos = response.data
            //console.log(response.data)
            //console.log(data.value.photos)
        })
        .catch(err => {
            console.error(err.message)
        })
})

function filterPhotos() {
    console.log(data.value.filter)
    axios.get(base_url + photos_endpoint + "/filter/" + data.value.filter.toString())
        .then(response => {
            data.value.photos.length = 0
            data.value.photos = response.data
            console.log(response.data)
            console.log(data.value.photos)
        })
        .catch(err => {
            console.error(err.message)
        })
}

</script>

<template>
    <div class="container pb-5">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-6 mb-4">
                <div class=" input-group shadow mb-4">
                    <input class="form-control user_input rounded-0" v-model="data.filter" type="search" name="filter"
                        id="filter">
                    <button class="btn btn_primary filter_btn rounded-0 d-flex align-items-center gap-2"
                        @click.prevent="filterPhotos()">
                        <box-icon name="search" type="solid" class=""></box-icon>
                        Search
                    </button>
                </div>
            </div>
        </div>
        <div class="row g-3" v-if="data.photos.length > 0">
            <div class="col-12 col-md-6 col-lg-4" v-for="photo in data.photos" v-show="photo.visible == true">
                <div class="rounded-0 border-0 shadow h-100 bg_light">
                    <div class="position-relative">
                        <img class="card-img-top rounded-0 object-fit-cover" height="300" width="200" :src="photo.url">
                        <span class="rounded-pill text-light px-3 position-absolute shadow fw-semibold"
                            style="bottom: 1rem; left: 1rem; background-color: rgba(0,0,0, 50%) !important;">@{{
                                photo.user.username }}</span>
                    </div>
                    <div class="p-3 d-flex flex-column justify-content-start align-items-start gap-2">
                        <h4 class="mb-0 text_italic">{{ photo.title }}</h4>
                        <p class="mb-0 description">{{ photo.description }}</p>
                        <ul class="list-unstyled d-flex align-items-center flex-wrap justify-content-start gap-2 mb-0">
                            <li class="" v-for="category in photo.categories">
                                <small class="text-italic">
                                    #{{ category.name }}
                                </small>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row g-3" v-else>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="rounded-0 border-0 shadow h-100 bg_light">
                    <div class="position-relative placeholder-glow">
                        <img class="card-img-top rounded-0 object-fit-contain placeholder p-5" height="300" width="200"
                            alt="laoding placeholder" src="/icon.svg" loading="lazy">
                        <span class="rounded-pill text-light px-3 position-absolute shadow fw-semibold placeholder"
                            style="bottom: 1rem; left: 1rem; background-color: rgba(0,0,0, 50%) !important;"></span>
                    </div>
                    <div class="p-3 d-flex flex-column justify-content-start align-items-start gap-2 placeholder-glow">
                        <h4 class="mb-0 text_italic placeholder"></h4>
                        <p class="mb-0 description placeholder"></p>
                        <ul class="list-unstyled d-flex align-items-center flex-wrap justify-content-start gap-2 mb-0">
                            <li class="">
                                <small class="text-italic placeholder">
                                </small>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="rounded-0 border-0 shadow h-100 bg_light">
                    <div class="position-relative placeholder-glow">
                        <img class="card-img-top rounded-0 object-fit-contain placeholder p-5" height="300" width="200"
                            alt="laoding placeholder" src="/icon.svg" loading="lazy">
                        <span class="rounded-pill text-light px-3 position-absolute shadow fw-semibold placeholder"
                            style="bottom: 1rem; left: 1rem; background-color: rgba(0,0,0, 50%) !important;"></span>
                    </div>
                    <div class="p-3 d-flex flex-column justify-content-start align-items-start gap-2 placeholder-glow">
                        <h4 class="mb-0 text_italic placeholder"></h4>
                        <p class="mb-0 description placeholder"></p>
                        <ul class="list-unstyled d-flex align-items-center flex-wrap justify-content-start gap-2 mb-0">
                            <li class="">
                                <small class="text-italic placeholder">
                                </small>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="rounded-0 border-0 shadow h-100 bg_light">
                    <div class="position-relative placeholder-glow">
                        <img class="card-img-top rounded-0 object-fit-contain placeholder p-5" height="300" width="200"
                            alt="laoding placeholder" src="/icon.svg" loading="lazy">
                        <span class="rounded-pill text-light px-3 position-absolute shadow fw-semibold placeholder"
                            style="bottom: 1rem; left: 1rem; background-color: rgba(0,0,0, 50%) !important;"></span>
                    </div>
                    <div class="p-3 d-flex flex-column justify-content-start align-items-start gap-2 placeholder-glow">
                        <h4 class="mb-0 text_italic placeholder"></h4>
                        <p class="mb-0 description placeholder"></p>
                        <ul class="list-unstyled d-flex align-items-center flex-wrap justify-content-start gap-2 mb-0">
                            <li class="">
                                <small class="text-italic placeholder">
                                </small>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="rounded-0 border-0 shadow h-100 bg_light">
                    <div class="position-relative placeholder-glow">
                        <img class="card-img-top rounded-0 object-fit-contain placeholder p-5" height="300" width="200"
                            alt="laoding placeholder" src="/icon.svg" loading="lazy">
                        <span class="rounded-pill text-light px-3 position-absolute shadow fw-semibold placeholder"
                            style="bottom: 1rem; left: 1rem; background-color: rgba(0,0,0, 50%) !important;"></span>
                    </div>
                    <div class="p-3 d-flex flex-column justify-content-start align-items-start gap-2 placeholder-glow">
                        <h4 class="mb-0 text_italic placeholder"></h4>
                        <p class="mb-0 description placeholder"></p>
                        <ul class="list-unstyled d-flex align-items-center flex-wrap justify-content-start gap-2 mb-0">
                            <li class="">
                                <small class="text-italic placeholder">
                                </small>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="rounded-0 border-0 shadow h-100 bg_light">
                    <div class="position-relative placeholder-glow">
                        <img class="card-img-top rounded-0 object-fit-contain placeholder p-5" height="300" width="200"
                            alt="laoding placeholder" src="/icon.svg" loading="lazy">
                        <span class="rounded-pill text-light px-3 position-absolute shadow fw-semibold placeholder"
                            style="bottom: 1rem; left: 1rem; background-color: rgba(0,0,0, 50%) !important;"></span>
                    </div>
                    <div class="p-3 d-flex flex-column justify-content-start align-items-start gap-2 placeholder-glow">
                        <h4 class="mb-0 text_italic placeholder"></h4>
                        <p class="mb-0 description placeholder"></p>
                        <ul class="list-unstyled d-flex align-items-center flex-wrap justify-content-start gap-2 mb-0">
                            <li class="">
                                <small class="text-italic placeholder">
                                </small>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="rounded-0 border-0 shadow h-100 bg_light">
                    <div class="position-relative placeholder-glow">
                        <img class="card-img-top rounded-0 object-fit-contain placeholder p-5" height="300" width="200"
                            alt="laoding placeholder" src="/icon.svg" loading="lazy">
                        <span class="rounded-pill text-light px-3 position-absolute shadow fw-semibold placeholder"
                            style="bottom: 1rem; left: 1rem; background-color: rgba(0,0,0, 50%) !important;"></span>
                    </div>
                    <div class="p-3 d-flex flex-column justify-content-start align-items-start gap-2 placeholder-glow">
                        <h4 class="mb-0 text_italic placeholder"></h4>
                        <p class="mb-0 description placeholder"></p>
                        <ul class="list-unstyled d-flex align-items-center flex-wrap justify-content-start gap-2 mb-0">
                            <li class="">
                                <small class="text-italic placeholder">
                                </small>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
@use "../assets/sass/variables.scss" as *;

.description {
    display: -webkit-box;
    max-width: 100%;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    overflow: hidden;
    text-overflow: ellipsis;
}

.filter_btn {
    &>* {
        fill: $ms-light !important;

    }

    &:hover>* {
        color: $ms-dark !important;
        fill: $ms-dark !important;
    }
}
</style>