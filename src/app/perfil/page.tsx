"use client";
import { Button } from "@/components/ui/button";
import { isAuthenticated, logout } from "@/services/auth";
import { redirect, useRouter } from "next/navigation";
import { useLayoutEffect } from "react";

export default function PerfilPage() {
  const router = useRouter();

  useLayoutEffect(() => {
    if (!isAuthenticated) {
      redirect("/login");
    }
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
