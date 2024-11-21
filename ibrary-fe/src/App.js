import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Layout from "./components/Layout";
import Home from "./pages/book/Home";
import Detail from "./pages/book/Detail";
import Add from "./pages/book/Add";
import Update from "./pages/book/Update";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />}></Route>
            <Route path="detail/:id" element={<Detail />}></Route>
            <Route path="add" element={<Add />}></Route>
            <Route path="update/:id" element={<Update />}></Route>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
