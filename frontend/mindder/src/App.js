import React from "react";
import './App.css';
import {
    BrowserRouter,
    Routes,
    Route
} from "react-router-dom";
import styled from "styled-components";
// Pages
import MainPage from './router/MainPage';
import PostPage from './router/PostPage';
import UserPage from './router/UserPage';
import FeedPage from './router/FeedPage';
import SearchPage from './router/SearchPage';
import CalendarPage from "./router/CalendarPage";
import FeedDetailPage from "./router/FeedDetailPage";
import FollowersPage from "./router/FollowersPage";
import FollowingPage from "./router/FollowingPage";
import JoinPage from "./router/JoinPage";
import LoginPage from "./router/LoginPage";
import ModifyPage from "./router/ModifyPage";
import PwChangePage from "./router/PwChangePage";
import PwFindPage from "./router/PwFindPage";
import RemovePage from "./router/RemovePage";
import SavedPage from "./router/SavedPage";
import SearchNamePage from "./router/SearchNamePage";
import SearchResPage from "./router/SearchResPage";
import SearchTagPage from "./router/SearchTagPage";
import NaviBar from './commons/bar/NaviBar';
import HeaderBar from "./commons/bar/HeaderBar";

const userId = 0
const idx = 0
const keyword = ''


function App(props) {
        return (
            <BrowserRouter>
                <HeaderBar/>
                <div id = "bodysuit">
                    <Routes>
                        <Route path="" element={<MainPage />} />
                        <Route path="user" element={<UserPage />} />
                        <Route path="feeds" element={<FeedPage />} />
                        <Route path="search" element={<SearchPage />} />
                        <Route path={`${userId}/calendar`} element={<CalendarPage />} />
                        <Route path={`f/${idx}`} element={<FeedDetailPage />} />
                        <Route path={`${userId}/followers`} element={<FollowersPage />} />
                        <Route path={`${userId}/following`} element={<FollowingPage />} />
                        <Route path="join" element={<JoinPage />} />
                        <Route path="login" element={<LoginPage />} />
                        <Route path="accounts/edit" element={<ModifyPage />} />
                        <Route path="post" element={<PostPage />} />
                        <Route path="accounts/password/change" element={<PwChangePage />} />
                        <Route path="accounts/password/find" element={<PwFindPage />} />
                        <Route path="accounts/remove" element={<RemovePage />} />
                        <Route path={`${userId}/saved`} element={<SavedPage />} />
                        <Route path={`search/${keyword}/nickname`} element={<SearchNamePage />} />
                        <Route path={`search/${keyword}`} element={<SearchResPage />} />
                        <Route path={`search/${keyword}/canvas`} element={<SearchTagPage />} />
                    </Routes>
                </div>
                <NaviBar/>
            </BrowserRouter>
        );

}

export default App;