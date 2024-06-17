"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";
import { ReactNode, useEffect, useState } from "react";

interface StyledLinkProps {
  children: ReactNode;
  href: string;
  className?: string;
}

export default function StyledLink({
  children,
  href,
  className,
  ...props
}: StyledLinkProps) {
  const pathname = usePathname();

  const defineActive = () => {
    if (pathname === href) {
      return "opacity-100";
    }
    return "opacity-50";
  };

  return (
    <Link
      href={href}
      className={
        defineActive() +
        " text-foreground transition-colors hover:opacity-100" +
        className
      }
      {...props}
    >
      {children}
    </Link>
  );
}
