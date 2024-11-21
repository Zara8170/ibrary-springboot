import React, { useState } from "react";
import { Link } from "react-router-dom";

export default function Header() {
  const [isCategoryOpen, setIsCategoryOpen] = useState(false);

  const toggleCategories = () => {
    setIsCategoryOpen(!isCategoryOpen);
  };

  return (
    <div className="space-y-8 mt-10">
      <h1 className="text-3xl md:text-4xl font-bold">상품 관리</h1>
      <nav className="flex flex-col space-y-4 text-lg items-start">
        <Link
          to="/"
          className="hover:underline hover:text-gray-300 transition duration-200 text-blue-500 text-sm"
        >
          상품리스트
        </Link>
        <span
          onClick={toggleCategories}
          className="cursor-pointer text-red-500 hover:text-red-700 transition duration-200 text-sm"
        >
          {isCategoryOpen ? "▽ 상품카테고리" : "▷ 상품카테고리"}
        </span>
        {isCategoryOpen && (
          <div className="pl-4 space-y-2 flex flex-col">
            <Link
              to={{
                pathname: "/category",
                search: "?category=sci",
              }}
              className="hover:underline hover:text-gray-300 transition duration-200 text-sm"
            >
              ☞ 과학
            </Link>
            <Link
              to={{
                pathname: "/category",
                search: "?category=tech",
              }}
              className="hover:underline hover:text-gray-300 transition duration-200 text-sm"
            >
              ☞ 기술
            </Link>
            <Link
              to={{
                pathname: "/category",
                search: "?category=lang",
              }}
              className="hover:underline hover:text-gray-300 transition duration-200 text-sm"
            >
              ☞ 언어
            </Link>
            <Link
              to={{
                pathname: "/category",
                search: "?category=novel",
              }}
              className="hover:underline hover:text-gray-300 transition duration-200 text-sm"
            >
              ☞ 소설
            </Link>
          </div>
        )}
        <Link
          to="/add"
          className="hover:underline hover:text-gray-300 transition duration-200 text-green-500 text-sm"
        >
          상품추가
        </Link>
      </nav>
    </div>
  );
}
