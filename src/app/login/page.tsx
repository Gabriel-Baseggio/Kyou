"use client";

import { Button } from "@/components/ui/button";
import { login } from "@/services/auth";
import { useRouter } from "next/navigation";

export default function LoginPage() {
  const router = useRouter();

  const handleClick = () => {
    login();
    router.push("/perfil");
  };

  return (
    <div>
      <h1>Login</h1>
      <Button onClick={handleClick}>Logar</Button>
    </div>
  );
}
