"use client";

import { useRouter } from "next/navigation";
import { Input } from "@/components/ui/input";
import { toast } from "sonner";
import { fetchData } from "@/tools/api";
import Link from "next/link";

export default function RegistroPage() {
  const router = useRouter();

  const registroUsuario = (e: FormData) => {
    const rawFormData = Object.fromEntries(e);
    const { username, password } = rawFormData;

    try {
      fetchData("/usuario/registro", {
        method: "POST",
        data: { username: username, password: password },
      }).then((data) => {
        toast.success("Usuário registrado com sucesso");
        router.replace("/login");
      });
    } catch (err) {
      toast.error("Erro ao cadastrar usuário");
      console.error(err);
    }
  };

  return (
    <div className="w-full h-full flex flex-col items-center justify-center">
      <form
        className="bg-muted rounded-2xl p-6 flex flex-col gap-4 items-center"
        action={registroUsuario}
      >
        <h3 className="text-3xl font-bold">Registro</h3>
        <Input type="text" placeholder="Usuário" name="username" required />
        <Input type="password" placeholder="Senha" name="password" required />
        <Input
          type="submit"
          className="bg-primary w-auto hover:cursor-pointer hover:bg-primary/90 active:scale-[0.98]"
          value="Registrar"
        />
        <Link href="/login" className="text-primary text-xs underline">
          Já tem uma conta? Faça login
        </Link>
      </form>
    </div>
  );
}
