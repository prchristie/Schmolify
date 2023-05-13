import { useRouter } from "next/router";
import SchmolService from "./services/schmol";
import { NextRequest, NextResponse } from "next/server";

export default async function middleware(request: NextRequest) {
  const pathname = request.nextUrl.pathname;

  const id = pathname.split("/").pop();

  const schmol = await SchmolService.get(id);
  console.log(schmol);
  if (!schmol) {
    return NextResponse.redirect(new URL(request.nextUrl.origin));
  }
  const url = schmol.url.startsWith("http")
    ? schmol.url
    : `https://${schmol.url}`;
  return NextResponse.redirect(new URL(schmol.url));
}

export const config = {
  matcher: "/go/:id+",
};
