<script setup>
import { RouterView } from 'vue-router'
import NavbarComponent from './components/NavbarComponent.vue'

</script>

<template>
	<div class="">
		<NavbarComponent />
	</div>
	<main class="">
		<RouterView />
	</main>
</template>

<style lang="scss" scoped></style>
