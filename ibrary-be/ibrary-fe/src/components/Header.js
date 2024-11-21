import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <div className="space-y-8 mt-10">
      <h1 className="text-3xl md:text-4xl font-bold">상품 관리</h1>
      <nav className="flex flex-col space-y-4 text-lg">
        <Link
          to="/"
          className="hover:underline hover:text-gray-300 transition duration-200 text-blue-500"
        >
          상품리스트
        </Link>
        <Link
          to="/add"
          className="hover:underline hover:text-gray-300 transition duration-200 text-green-500"
        >
          상품추가
        </Link>
      </nav>
    </div>
  );
}
