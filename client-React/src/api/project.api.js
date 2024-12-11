import axios from 'axios'


const projectsApi = axios.create({
    baseURL: "https://api.github.com/search/users?q=moises",
});

export const getAllProjects = () => projectsApi.get("/");


export const createProjects = (project) => projectsApi.post("/", project);
