"use client";

import { Input } from "@/components/ui/input";
import { login } from "@/services/auth";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { toast } from "sonner";

export default function LoginPage() {
  const router = useRouter();

  const loginUsuario = (e: FormData) => {
    const rawFormData = Object.fromEntries(e);
    const { username, password } = rawFormData;

    try {
      login(username.toString(), password.toString()).then((data) => {
        if (data.error != undefined) {
          toast.error(data.error);
        } else {
          toast.success(data.message);
          router.replace("/");
        }
      });
    } catch (err) {
      console.error(err);
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
          value="Logar"
        />
        <Link href="/registro" className="text-primary text-xs underline">
          Ainda não tem uma conta? Registre-se
        </Link>
      </form>
    </div>
  );
}
