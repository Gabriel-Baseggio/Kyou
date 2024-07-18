"use server";

import { fetchData } from "@/tools/api";
import { addSeconds } from "date-fns";
import { cookies } from "next/headers";

export const login = async (username: string, password: string) => {
  let response = await fetchData("/usuario/login", {
    method: "POST",
    data: { username: username, password: password },
  })
    .then((data) => {
      cookies().set("token", data.token, {
        expires: addSeconds(new Date(), data.expiresIn),
      });
      return { message: "Usuário logado com sucesso", error: undefined };
    })
    .catch((err) => {
      return { message: undefined, error: "Erro ao logar usuário" };
    });

  return response;
};

export const getCookie = async (name: string) => {
  return cookies().get(name)?.value;
};

export const checkAuth = async () => {
  if (cookies().get("token") != undefined) {
    return true;
  }
  return false;
};

export const logout = async () => {
  cookies().delete("token");
  return;
};
