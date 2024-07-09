import type { Metadata } from "next";
import { Outfit } from "next/font/google";
import "./globals.css";
import { ThemeProvider } from "@/components/theme-provider";

import Header from "../components/header";
import Footer from "@/components/footer";
import { Toaster } from "@/components/ui/sonner";

const outfit = Outfit({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Kyou",
  description: "Developed by @baseggio",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
        className={
          outfit.className + " min-h-screen flex flex-col justify-between"
        }
      >
        <ThemeProvider
          attribute="class"
          defaultTheme="system"
          enableSystem
          disableTransitionOnChange
        >
          <Header />
          <main>
            {children}
            <Toaster duration={1000} expand richColors />
          </main>
          <Footer />
        </ThemeProvider>
      </body>
    </html>
  );
}
