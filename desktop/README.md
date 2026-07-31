# transformed 桌面版

现代化 UI 的格式转换和视频下载工具。一键打包为 exe，开箱即用。

## 功能

| 功能 | 说明 |
|------|------|
| 📁 EPUB → TXT | 批量转换电子书为纯文本 |
| 🎬 MP4 → MP3 | 批量提取视频音频 |
| 🖼 WebP → JPG | 批量转换图片格式 |
| 🌐 网络下载 | B站 / YouTube / Twitter 视频下载 |

## 快速使用

### 方法一：直接下载打包好的 exe
1. 下载 `transformed.exe`
2. 双击运行
3. 如需 MP4→MP3 功能，安装 ffmpeg

### 方法二：自己打包
1. 双击 `build_exe.bat`
2. 等待打包完成
3. 在 `dist/transformed.exe` 找到 exe

### 方法三：源码运行
```bash
pip install ttkbootstrap pillow yt-dlp mutagen ebooklib
python main.py
```

## 依赖

- **Python 3.8+**
- **ffmpeg**（可选，MP4→MP3 需要）
  下载: https://ffmpeg.org/download.html
  或 `winget install ffmpeg`

## 界面预览

采用 ttkbootstrap 现代化主题，深色/浅色自适应。
