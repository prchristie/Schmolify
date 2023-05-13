import { useRouter } from "next/router";

export default async function dwa() {
  const router = useRouter();
  const id = router.query.id;

  const res = await fetch(`http://localhost:8080/api/v1/schmol/${id}`);
  console.log(res);
  return <div>test</div>;
}
