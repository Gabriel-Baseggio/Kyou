"use client";

import { Input } from "@/components/ui/input";
import { login } from "@/services/auth";
import { toast } from "sonner";

export default function LoginPage() {
  const loginUsuario = (e: FormData) => {
    const rawFormData = Object.fromEntries(e);
    const { username, password } = rawFormData;

    try {
      login(username.toString(), password.toString()).then((data) => {
        toast.success(data);
      });
    } catch (err) {
      toast.error("Usuário ou senha incorretos");
    }
  };

  return (
    <div className="w-full h-full flex flex-col items-center justify-center">
      <form
        className="bg-muted rounded-2xl p-6 flex flex-col gap-4 items-center"
        action={loginUsuario}
      >
        <h3 className="text-3xl font-bold">Login</h3>
        <Input type="text" placeholder="Usuário" name="username" required />
        <Input type="password" placeholder="Senha" name="password" required />
        <Input
          type="submit"
          className="bg-primary w-auto hover:cursor-pointer hover:bg-primary/90 active:scale-[0.98]"
        />
      </form>
    </div>
  );
}
