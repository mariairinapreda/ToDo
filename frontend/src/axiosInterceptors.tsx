import axios, {AxiosResponse, InternalAxiosRequestConfig} from "axios";
import {URL_DATA} from "./constants";

const authFetch = axios.create({
    baseURL: URL_DATA,
});

authFetch.interceptors.request.use((request: InternalAxiosRequestConfig) => {
        axios.defaults.headers['Accept'] = 'application/json'
    return request;
}, (error: Error) => {
    return Promise.reject(error);
})


authFetch.interceptors.response.use((response: AxiosResponse) => {
    return response;
}, (error) => {
    console.log(error)
    if (error.response.status === 500) {
        alert("SERVER IS DOWN")
    } else if (error.response.status === 404) {
        alert("NOT FOUND")
    }
    return Promise.reject(error);
})
export const apiAction = async (url: string) => {
    const response = await authFetch.get(url)
    return response.data;
}
export const deleteApi = async (param: string) => {
    const response = await authFetch.delete(param);
    return response.data;
}
export default authFetch;