import { fetchData } from "@/tools/api";

export let isAuthenticated = false;

export const login = async (username: string, password: string) => {
  isAuthenticated = true;

  return fetchData("usuario/login", {
    method: "POST",
    data: { username: username, password: password },
  })
    .then((data) => {
      return "Usuário logado com sucesso";
    })
    .catch((err) => {
      throw new Error();
    });
};

export const logout = () => {
  isAuthenticated = false;
};
