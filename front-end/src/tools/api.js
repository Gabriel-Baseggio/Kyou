import { checkAuth, getCookie } from "@/services/auth";
import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080",
  fetchOptions: { mode: "no-cors" },
});

export const fetchData = async (url, options = {}) => {
  if (await checkAuth()) {
    options.headers = {
      Authorization: `Bearer ${await getCookie("token")}`,
    };
  }

  const response = await axiosInstance(url, options);
  return response.data;
};
