"use client";
import { Button } from "@/components/ui/button";
import { checkAuth, logout } from "@/services/auth";
import { useRouter } from "next/navigation";
import { useLayoutEffect } from "react";

export default function PerfilPage() {
  const router = useRouter();

  const checkCookies = async () => {
    if (!(await checkAuth())) {
      router.replace("/login");
    }
  };

  useLayoutEffect(() => {
    checkCookies();
  }, []);

  const handleClick = () => {
    logout();
    router.push("/login");
  };

  return (
    <div>
      <h1>Perfil</h1>
      <Button onClick={handleClick}>Deslogar</Button>
    </div>
  );
}
