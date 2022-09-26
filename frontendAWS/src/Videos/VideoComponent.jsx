import React from 'react'
import VideoPlayer from 'react-player';
import Video from '../Videos/videoplayback.mp4';

export default function VideoComponent() {

const videosrc = Video;
  return (
    <div>
        <VideoPlayer
            url='https://www.youtube.com/watch?v=YO6iTj2dj5M'
        />
    </div>
  )
}
