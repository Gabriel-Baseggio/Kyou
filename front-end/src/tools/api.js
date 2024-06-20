import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/",
  fetchOptions: { mode: "no-cors" },
});

export const fetchData = async (url, options = {}) => {
  try {
    const response = await axiosInstance(url, options);
    return response.data;
  } catch (error) {
    console.error("Error retrieving data:", error);
    throw new Error("Could not get data");
  }
};
